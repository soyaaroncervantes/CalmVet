package com.soyaaroncervantes.calmvet.view.fragments.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.soyaaroncervantes.calmvet.databinding.FragmentPetsBinding
import com.soyaaroncervantes.calmvet.view.adapter.PetsAdapter
import com.soyaaroncervantes.calmvet.viewmodel.PetsViewModel
import com.soyaaroncervantes.calmvet.viewmodel.ToolbarViewModel

class PetsFragment : Fragment() {
  /* #Binding */
  private lateinit var binding: FragmentPetsBinding;

  /* #ViewModel */
  private val toolbarViewModel: ToolbarViewModel by viewModels()
  private val petsViewModel: PetsViewModel by viewModels()

  /* #Adapter */
  private var petsAdapter: PetsAdapter? = null

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    binding = FragmentPetsBinding.inflate(inflater, container, false)
    setupRecyclerView()
    return binding.root
  }

  override fun onStart() {
    super.onStart()
    petsAdapter?.startListening()
  }

  override fun onDestroy() {
    super.onDestroy()
    petsAdapter?.stopListening()
  }

  override fun onResume() {
    super.onResume()
    toolbarViewModel.setTitle("Mascotas")
  }

  private fun setupRecyclerView() {
    val recyclerView = binding.recyclerViewPets
    val firestoreRecyclerOptions = petsViewModel.pets()
    petsAdapter = PetsAdapter(firestoreRecyclerOptions)
    recyclerView.layoutManager = LinearLayoutManager(this.context)
    recyclerView.adapter = petsAdapter
    binding.relativeLayoutPets.visibility = View.INVISIBLE
  }

}