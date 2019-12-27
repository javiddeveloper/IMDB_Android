package ir.javid.developer.imdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.javid.developer.imdb.sections.infoMovie.InfoMovieFragment
import ir.javid.developer.imdb.sections.listMovie.ListMovieFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, ListMovieFragment.newInstance())
            .commit()
    }
}
