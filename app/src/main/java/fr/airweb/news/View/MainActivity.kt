package fr.airweb.news.View
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.airweb.news.Model.RetrofitClientInstance
import fr.airweb.news.Model.dto.NewsDTO
import fr.airweb.news.Model.dto.NewsList
import fr.airweb.news.R
import fr.airweb.news.ViewModel.GetNewService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.item_news_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var News_List : RecyclerView
        lateinit var newsAdapter: NewsAdapter


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        News_List = findViewById(R.id.News)
        News_List.adapter


        val service = RetrofitClientInstance.retrofitInstance?.create(GetNewService::class.java)
        val call = service?.getAllNews()?.subscribeOn(Schedulers.io())?.unsubscribeOn(Schedulers.computation())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({
                val news : NewsList = it
                newsAdapter.setNews(it.data)

                //TODO : Ecraser les données de la table et les remplacer par les nouvelles


                /**
                 * insert data into the database*/
                /*
                var db = Room.databaseBuilder(applicationContext,NewsApp_DB::class.java,"NewsDB").build()
                Thread{

                    //insert data
                    var news = NewsApp_Entity()
                    //Example of an insert into the table
                    news.nid = 1

                }.start()
                */
            },{
                /*Log.v("erreur",t.message,t)//To change body of created functions use File | Settings | File Templates.
                Toast.makeText(applicationContext,"Error reading JSON",Toast.LENGTH_LONG).show()*/

                /**
                 * example of how to read the database*/
                /*
                    db.useDAO().saveNews(news)
                    db.useDAO().readNews().forEach{
                        Log.i("", "Id is : ${it.nid}")
                        Log.i("", "Title is : ${it.title}")
                        Log.i("", "Type is : ${it.type}")
                    }*/
                //TODO : Lire la table news

            })


    }

    abstract inner class NewsAdapter :  RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

        private val news : List<NewsDTO> = mutableListOf()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
            return NewsViewHolder(layoutInflater.inflate(R.layout.item_news_layout,parent,false))
        }

        override fun getItemCount(): Int {
            return news.size
        }

        override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
            holder.bindModel(news[position])
        }

        inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val newsTitleTxt: TextView = newsTitle
            val newsContextTxt : TextView = newsContent
            val picture : ImageView = newsPicture

            //need to initialize type and others from the list

            fun bindModel(newsList: NewsDTO) {
                newsTitleTxt.text = newsList.title
                newsContextTxt.text = newsList.content
                Picasso.get().load(newsList.picture).into(picture)

            }
        }

    }


}
