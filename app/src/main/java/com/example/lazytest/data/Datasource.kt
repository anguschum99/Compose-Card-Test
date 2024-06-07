package com.example.lazytest.data

import com.example.lazytest.Cunny
import com.example.lazytest.R

class Datasource {
    fun loadCunny(): List<Cunny>{
        return listOf<Cunny>(
            Cunny(R.string.Sensei, R.drawable._662300388983169),
            Cunny(R.string.Sensei2, R.drawable._712308158510082),
            Cunny(R.string.Azusa, R.drawable._685638555940910),
            Cunny(R.string.Seia, R.drawable._707147344234575),
            Cunny(R.string.Koharu, R.drawable.image),
            )
    }
}