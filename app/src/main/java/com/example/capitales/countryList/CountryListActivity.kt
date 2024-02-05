package com.example.capitales.countryList

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capitales.api.ApiResponseStatus
import com.example.capitales.countryDetail.CountryDetailActivity
import com.example.capitales.countryDetail.CountryDetailActivity.Companion.COUNTRY_KEY
import com.example.capitales.databinding.ActivityCountryListBinding

private const val GRID_SPAN_COUNT = 3
class CountryListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCountryListBinding

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                // Permission is granted. Continue the action or workflow in your
                // app.
                startCamera()
            } else {
                Toast.makeText(this, "You needs accept permission camera to use camera", Toast.LENGTH_SHORT).show()
            }
        }

    private val countryListViewModel: CountryListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loadingWheel = binding.loadingWheel

        val recycler = binding.countryRecycler
        recycler.layoutManager = GridLayoutManager(this, GRID_SPAN_COUNT)

        val adapter = CountryAdapter()
        adapter.setOnItemClickListener {
            //pasar el country a country detail activity, para esto el obj debe ser parelable (para pasar un objeto entre activities)
            val intent = Intent(this, CountryDetailActivity::class.java)
            intent.putExtra(COUNTRY_KEY, it)
            startActivity(intent)
        }
        recycler.adapter = adapter

        countryListViewModel.countryList.observe(this){
            countryList->
            adapter.submitList(countryList)
        }

        countryListViewModel.status.observe(this){
            status ->
            when(status){
                is ApiResponseStatus.Error -> {
                    loadingWheel.visibility = View.GONE
                    Toast.makeText(this, status.message, Toast.LENGTH_SHORT).show()
                }
                is ApiResponseStatus.Loading -> loadingWheel.visibility = View.VISIBLE
                is ApiResponseStatus.Success ->{
                    loadingWheel.visibility = View.GONE
                }
            }
        }
        requestCameraPermission()
    }

    private fun requestCameraPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            when {
                ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED -> {
                    startCamera()
                }
                ActivityCompat.shouldShowRequestPermissionRationale(
                    this, Manifest.permission.CAMERA) -> {
                    // In an educational UI, explain to the user why your app requires this
                    // permission for a specific feature to behave as expected, and what
                    // features are disabled if it's declined. In this UI, include a
                    // "cancel" or "no thanks" button that lets the user continue
                    // using your app without granting the permission.
                    AlertDialog.Builder(this)
                        .setTitle("Aceptar")
                        .setMessage("Acepta la camara")
                        .setPositiveButton(android.R.string.ok){
                                _,_ ->
                            requestPermissionLauncher.launch(
                                Manifest.permission.CAMERA
                            )
                        }
                        .setNegativeButton(android.R.string.cancel){
                                _,_ ->
                        }.show()

                }
                else -> {
                    // You can directly ask for the permission.
                    // The registered ActivityResultCallback gets the result of this request.
                    requestPermissionLauncher.launch(
                        Manifest.permission.CAMERA)
                }
            }
        else{
            startCamera()
        }
    }

    private fun startCamera(){
        val cameraProviderFuture =
            ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build()
            preview.setSurfaceProvider(binding.cameraPreview.surfaceProvider)
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            cameraProvider.bindToLifecycle(
                this, cameraSelector, preview
            )
        }, ContextCompat.getMainExecutor(this))
    }

}