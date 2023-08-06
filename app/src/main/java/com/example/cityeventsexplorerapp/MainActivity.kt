package com.example.cityeventsexplorerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodorderapp.util.info_event.InfoEventCollector
import com.example.foodorderapp.util.info_event.InfoEventCollectorImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), InfoEventCollector by InfoEventCollectorImpl() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}