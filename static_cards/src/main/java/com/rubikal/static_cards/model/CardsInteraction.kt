package com.rubikal.static_cards.model

import android.content.Context
import com.rubikal.static_cards.static_cards.model.DiscoverCard
import com.rubikal.static_cards.util.openChromeCustomTab

interface CardsInteraction {

    fun onStaticCardClicked(card: DiscoverCard, context: Context){
        openChromeCustomTab(card, context)
    }

    fun openCareersActivity()
}