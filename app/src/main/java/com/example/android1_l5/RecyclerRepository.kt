package com.example.android1_l5

class RecyclerRepository {

    private val listOfCharacters: ArrayList<RecyclerModel> = ArrayList()

    fun getListOfCelebrities(): ArrayList<RecyclerModel> {
        listOfCharacters.add(
            RecyclerModel(
"https://static.wikia.nocookie.net/bleachpedia/images/1/1a/2022-11-04_20-36-29_%286%29.jpg/revision/latest?cb=20221104152620&path-prefix=ru",
                "Ичиго",
                27,
                "Куросаки"
            )
        )
        listOfCharacters.add(
            RecyclerModel(
                "https://static.wikia.nocookie.net/bleachpedia/images/7/7d/2022-11-04_20-36-29_%285%29.jpg/revision/latest?cb=20221104154126&path-prefix=ru",
                "Генрюусай",
                2000,
                "Ямамото"
            )
        )
        listOfCharacters.add(
            RecyclerModel(
                "https://static.wikia.nocookie.net/bleachpedia/images/b/b8/Яхве_эпизод1.jpg/revision/latest?cb=20221010102651&path-prefix=ru",
                "Яхве",
                1200,
                "Квинси"

            )
        )
        listOfCharacters.add(
            RecyclerModel(
                "https://static.wikia.nocookie.net/bleachpedia/images/f/fc/2022-11-04_20-36-29_%2829%29.jpg/revision/latest?cb=20221104152159&path-prefix=ru",
                "Урюу ",
                27,
                "Исида"
            )
        )
        listOfCharacters.add(
            RecyclerModel(
                "https://static.wikia.nocookie.net/bleachpedia/images/c/c3/2022-11-04_21-21-26.jpg/revision/latest?cb=20221104155642&path-prefix=ru",
                "Рецу ",
                1000,
                "Унохана"
            )
        )
        return listOfCharacters
    }
}