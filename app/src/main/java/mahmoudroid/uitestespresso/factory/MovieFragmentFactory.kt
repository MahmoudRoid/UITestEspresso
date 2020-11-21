package mahmoudroid.uitestespresso.factory

import androidx.fragment.app.FragmentFactory
import mahmoudroid.uitestespresso.data.source.MoviesDataSource
import mahmoudroid.uitestespresso.ui.movie.DirectorsFragment
import mahmoudroid.uitestespresso.ui.movie.MovieDetailFragment
import mahmoudroid.uitestespresso.ui.movie.StarActorsFragment

class MovieFragmentFactory : FragmentFactory(){

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when(className){

            MovieDetailFragment::class.java.name -> {
                MovieDetailFragment()
            }

            DirectorsFragment::class.java.name -> {
                DirectorsFragment()
            }

            StarActorsFragment::class.java.name -> {
                StarActorsFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }


}