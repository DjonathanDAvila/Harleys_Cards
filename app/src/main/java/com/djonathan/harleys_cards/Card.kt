package com.djonathan.harleys_cards

import androidx.annotation.DrawableRes

class Card(val id: Int, val nome: String, val anoFab: Int, @DrawableRes val imagem: Int) {
    constructor() : this(0, "", 0, 0)

    private var listCards: MutableList<Card> = mutableListOf()

    companion object {
        val DataCards: List<Card> = listOf(
            Card(1, "Fatboy", 1990, R.drawable.fatboy_1990),
            Card(2, "Fatboy", 2005, R.drawable.fatboy_2005),
            Card(3, "Fatboy", 2007, R.drawable.fatboy_2007),
            Card(4, "Fatboy", 2010, R.drawable.fatboy_2010)
        )
    }

    fun getDataCards() {
        listCards.addAll(DataCards)
    }

    fun loadDataCards() {
        listCards.addAll(DataCards)
    }

    fun findCardByID(prId: Int): Card? {
        return listCards.find { it.id == prId }
    }


}