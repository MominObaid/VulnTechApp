package com.example.vulntechapp.home

import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vulntechapp.HomeData
import com.example.vulntechapp.R

class HomeFragment : Fragment() {
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewChallenges)
        progressBar = view.findViewById(R.id.progressBar)

        setupRecyclerView()
        loadMockData()
    }

    private fun setupRecyclerView(){
    homeAdapter = HomeAdapter(emptyList())
    recyclerView.adapter = homeAdapter
    recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }


    private fun loadMockData(){
        progressBar.visibility = View.VISIBLE

        android.os.Handler(Looper.getMainLooper()).postDelayed({
            val mockData = createMockDataList()
            homeAdapter.updateData(mockData)
            progressBar.visibility = View.GONE
        },1500)
    }

    private fun createMockDataList(): List<HomeData>{
        return listOf(
            HomeData(1, "SQL Injection 101", "Web", 100, 523),
            HomeData(2, "XSS Basics", "Web", 150, 411),
            HomeData(3, "Classic Caesar Cipher", "Cryptography", 50, 890),
            HomeData(4, "RSA Encryption", "Cryptography", 300, 150),
            HomeData(5, "Memory Forensics", "Forensics", 250, 210),
            HomeData(6, "Buffer Overflow Prep", "Pwn", 400, 88),
            HomeData(7, "Simple Reverse Engineering", "Reverse", 200, 305),
            HomeData(8, "Memory Forensics", "Forensics", 250, 210),
            HomeData(9, "Buffer Overflow Prep", "Pwn", 400, 88),
            HomeData(10, "Simple Reverse Engineering", "Reverse", 200, 305)
        )
    }
}