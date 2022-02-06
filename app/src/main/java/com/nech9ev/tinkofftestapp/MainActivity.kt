package com.nech9ev.tinkofftestapp

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.tabs.TabLayout
import com.nech9ev.core.GifCategory
import com.nech9ev.domain.model.Gif
import com.nech9ev.tinkofftestapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private var errorDialog: Dialog? = null

    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        GifAdapter(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter

        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.recycler)

        setupTabs()

        lifecycleScope.launchWhenCreated {
            viewModel.gif.collect {newGif ->
                when(newGif){
                    is ActionState.Success -> {
                        postNewGif(newGif.data)
                    }
                    is ActionState.Loading ->{
                        Log.d("MY_TAG", "Loading..")
                    }
                    is ActionState.Error ->{
                        showAlert(newGif.message.toString())
                    }
                    is ActionState.Idle ->{
                        Log.d("MY_TAG", "Idling")
                    }
                }
            }
        }
        initScrollListener()
    }

    private fun postNewGif(newGif: Gif){
        adapter.addGif(newGif)
    }

    private fun initScrollListener() {
        binding.recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
                if (viewModel.gif.value !is ActionState.Loading<*> &&
                    viewModel.gif.value !is ActionState.Error<*> &&
                    linearLayoutManager != null &&
                    (linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1) == viewModel.getNumLoadedGif()
                ) {
                    viewModel.getNextGif()
                }
            }
        })
    }

    private fun setupTabs() {
        binding.tabLayoutCategory.getTabAt(1)!!.select()
        binding.tabLayoutCategory.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab!!.position){
                    0 -> changeCategory(GifCategory.HOT)
                    1 -> changeCategory(GifCategory.LATEST)
                    2 -> changeCategory(GifCategory.TOP)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselect
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselect
            }
        })
    }

    fun changeCategory(category: GifCategory){
        viewModel.changeCategory(category)
        adapter.clear()
    }

    fun showAlert(
        message: String,
        positiveAction: (() -> Unit)? = null,
        negativeButton: CharSequence? = null,
        positiveButton: CharSequence? = null,
        dismissAction: (() -> Unit)? = null,
        cancelAction: (() -> Unit)? = null,
    ) {
        errorDialog?.dismiss()
        errorDialog = MaterialAlertDialogBuilder(this)
            .setTitle(R.string.network_exception)
            .setMessage(message)
            .setPositiveButton(positiveButton) { _, _ -> positiveAction?.invoke() }
            .setNegativeButton(negativeButton, null)
            .setOnDismissListener { dismissAction?.invoke() }
            .setOnCancelListener { cancelAction?.invoke() }
            .show()
    }
}