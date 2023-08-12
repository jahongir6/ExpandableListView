package com.example.expandablelistview.utils

object MyData {

    val map = HashMap<String,ArrayList<String>>()
    val titleList = ArrayList<String>()

    fun addElement(){
        titleList.add("Android11")
        titleList.add("Android12")
        titleList.add("Android13")

        val list11 = ArrayList<String>()
        list11.add("javohir")
        list11.add("jasur")
        list11.add("abdugani")

        val list12 = ArrayList<String>()
        list12.add("jabbor")
        list12.add("jora")
        list12.add("mahliyo")

        val list13 = ArrayList<String>()
        list13.add("kamola")
        list13.add("laylo")
        list13.add("barno")
        list13.add("mahliyo")

        map[titleList[0]] = list11
        map[titleList[1]] = list12
        map[titleList[2]] = list13
    }

}