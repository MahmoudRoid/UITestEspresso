package mahmoudroid.uitestespresso.data.source


import mahmoudroid.uitestespresso.data.FakeMovieData
import mahmoudroid.uitestespresso.data.Movie

class MoviesRemoteDataSource: MoviesDataSource {

    private var MOVIES_REMOTE_DATA = LinkedHashMap<Int, Movie>(FakeMovieData.movies.size)

    init {
        for (movie in FakeMovieData.movies){
            addMovie(movie)
        }
    }

    override fun getMovies(): List<Movie> {
        return ArrayList(MOVIES_REMOTE_DATA.values)
    }

    override fun getMovie(movieId: Int): Movie? {
        return MOVIES_REMOTE_DATA[movieId]
    }

    private fun addMovie(
        movie: Movie
    ){
        MOVIES_REMOTE_DATA[movie.id] = movie
    }


}

