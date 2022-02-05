package com.nech9ev.data.datasource

import com.nech9ev.data.model.GifDTO
import com.nech9ev.data.model.GifResponse
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class JsonGifDataSourceImplTest {
    private lateinit var json: Json
    private lateinit var jsonStringCategoryGif: String
    private lateinit var jsonStringRandomGif: String

    @Test
    fun jsonFetchGitPage() {
        val gifResponse: GifResponse = json.decodeFromString(jsonStringCategoryGif)


        assertEquals(gifResponse.totalCount, 129_24)
        assertEquals(gifResponse.result[0].author, "xakep")
    }

    @Test
    fun jsonFetchRandomGif() {
        val gifDTO: GifDTO = json.decodeFromString(jsonStringRandomGif)

        assertEquals(gifDTO.description, "Когда пытаешься открыть месячный дамп базы в Блокноте Windows.")
        assertEquals(gifDTO.author, "pikachu")
    }

    @Before
    fun setup(){
        json = Json {
            ignoreUnknownKeys = true
            encodeDefaults = true
            coerceInputValues = true
            isLenient = true
        }

        jsonStringCategoryGif = """
                    {
   "result":[
      {
         "id":17090,
         "description":"Unhandled exception",
         "votes":5,
         "author":"xakep",
         "date":"Oct 26, 2021 10:05:22 AM",
         "gifURL":"http://static.devli.ru/public/images/gifs/202109/518d3a2b-42eb-4b05-8e81-a5329a1d8288.gif",
         "gifSize":8031076,
         "previewURL":"https://static.devli.ru/public/images/previews/202109/518d3a2b-42eb-4b05-8e81-a5329a1d8288.jpg",
         "videoURL":"http://static.devli.ru/public/images/v/202109/518d3a2b-42eb-4b05-8e81-a5329a1d8288.mp4",
         "videoPath":"/public/images/v/202109/518d3a2b-42eb-4b05-8e81-a5329a1d8288.mp4",
         "videoSize":970357,
         "type":"gif",
         "width":"480",
         "height":"592",
         "commentsCount":1,
         "fileSize":8031076,
         "canVote":false
      },
      {
         "id":17088,
         "description":"Накануне дедлайна",
         "votes":5,
         "author":"w3lifer",
         "date":"May 17, 2021 12:47:20 PM",
         "gifURL":"http://static.devli.ru/public/images/gifs/202105/338eec95-f956-4aa6-8844-219166979cc2.gif",
         "gifSize":637391,
         "previewURL":"https://static.devli.ru/public/images/previews/202105/338eec95-f956-4aa6-8844-219166979cc2.jpg",
         "videoURL":"http://static.devli.ru/public/images/v/202105/338eec95-f956-4aa6-8844-219166979cc2.mp4",
         "videoPath":"/public/images/v/202105/338eec95-f956-4aa6-8844-219166979cc2.mp4",
         "videoSize":172526,
         "type":"gif",
         "width":"232",
         "height":"154",
         "commentsCount":0,
         "fileSize":637391,
         "canVote":false
      },
      {
         "id":17075,
         "description":"Правильное использование фичи библиотеки из не самого доверенного исчтоника.",
         "votes":8,
         "author":"Alex_158",
         "date":"Oct 20, 2020 1:33:10 PM",
         "gifURL":"http://static.devli.ru/public/images/gifs/202009/3c2dbbe9-da67-4df3-8790-0fa3d995ceeb.gif",
         "gifSize":2039413,
         "previewURL":"https://static.devli.ru/public/images/previews/202009/3c2dbbe9-da67-4df3-8790-0fa3d995ceeb.jpg",
         "videoURL":"http://static.devli.ru/public/images/v/202009/3c2dbbe9-da67-4df3-8790-0fa3d995ceeb.mp4",
         "videoPath":"/public/images/v/202009/3c2dbbe9-da67-4df3-8790-0fa3d995ceeb.mp4",
         "videoSize":1380587,
         "type":"gif",
         "width":"610",
         "height":"255",
         "commentsCount":2,
         "fileSize":2039413,
         "canVote":false
      },
      {
         "id":17073,
         "description":".hairstyle {margin-top: -10px;}",
         "votes":16,
         "author":"agentsib",
         "date":"Jul 27, 2020 2:25:49 PM",
         "gifURL":"http://static.devli.ru/public/images/gifs/202007/f1e78b48-3bf9-4184-8ec5-471ee80f3f76.gif",
         "gifSize":8436134,
         "previewURL":"https://static.devli.ru/public/images/previews/202007/f1e78b48-3bf9-4184-8ec5-471ee80f3f76.jpg",
         "videoURL":"http://static.devli.ru/public/images/v/202007/f1e78b48-3bf9-4184-8ec5-471ee80f3f76.mp4",
         "videoPath":"/public/images/v/202007/f1e78b48-3bf9-4184-8ec5-471ee80f3f76.mp4",
         "videoSize":536516,
         "type":"gif",
         "width":"320",
         "height":"320",
         "commentsCount":1,
         "fileSize":8436134,
         "canVote":false
      },
      {
         "id":17072,
         "description":"Нашел в API крутую фичу",
         "votes":15,
         "author":"analizatar",
         "date":"Jul 20, 2020 10:05:42 AM",
         "gifURL":"http://static.devli.ru/public/images/gifs/202007/1687d750-5332-4cef-b4d9-0e1669523762.gif",
         "gifSize":9574611,
         "previewURL":"https://static.devli.ru/public/images/previews/202007/1687d750-5332-4cef-b4d9-0e1669523762.jpg",
         "videoURL":"http://static.devli.ru/public/images/v/202007/1687d750-5332-4cef-b4d9-0e1669523762.mp4",
         "videoPath":"/public/images/v/202007/1687d750-5332-4cef-b4d9-0e1669523762.mp4",
         "videoSize":2581105,
         "type":"gif",
         "width":"460",
         "height":"674",
         "commentsCount":0,
         "fileSize":9574611,
         "canVote":false
      }
   ],
   "totalCount":12924
}
       
                                """
        jsonStringRandomGif = """
            {
               "id":942,
               "description":"Когда пытаешься открыть месячный дамп базы в Блокноте Windows.",
               "votes":761,
               "author":"pikachu",
               "date":"Apr 16, 2013 7:12:16 PM",
               "gifURL":"http://static.devli.ru/public/images/gifs/201304/ef2f93ae-6756-4c58-ac4e-cb2e6bd2925e.gif",
               "gifSize":471665,
               "previewURL":"https://static.devli.ru/public/images/previews/201304/864d9e4a-38ba-4dc0-87e1-26ba9e3a0d04.jpg",
               "videoURL":"http://static.devli.ru/public/images/v/201304/89f3e870-5e30-49fb-9ef0-31ef79727d5f.mp4",
               "videoPath":"/public/images/v/201304/89f3e870-5e30-49fb-9ef0-31ef79727d5f.mp4",
               "videoSize":41980,
               "type":"gif",
               "width":"480",
               "height":"360",
               "commentsCount":0,
               "fileSize":471665,
               "canVote":false
            }
        """
    }
}