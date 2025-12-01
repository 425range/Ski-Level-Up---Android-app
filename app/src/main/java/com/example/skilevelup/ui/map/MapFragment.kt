package com.example.skilevelup.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.skilevelup.R
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_map, container, false)

        val mapFragment = childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        return view
    }

    override fun onMapReady(googleMap: GoogleMap) {
        // 스키장 좌표
        val yongpyong = LatLng(37.6452, 128.6800)
        val vivaldi = LatLng(37.6433, 127.6813)
        val phionex = LatLng(37.577, 128.322)
        val highone = LatLng(37.209, 128.822)
        val welihili = LatLng(37.301, 127.925)
        val elisian = LatLng(37.784, 127.633)
        val muju = LatLng(35.8921, 127.7405)
        val gonjiam = LatLng(37.338, 127.299)

        googleMap.addMarker(MarkerOptions().position(yongpyong).title("용평리조트"))
        googleMap.addMarker(MarkerOptions().position(vivaldi).title("비발디파크"))
        googleMap.addMarker(MarkerOptions().position(phionex).title("휘닉스파크"))
        googleMap.addMarker(MarkerOptions().position(highone).title("하이원리조트"))
        googleMap.addMarker(MarkerOptions().position(welihili).title("웰리힐리파크"))
        googleMap.addMarker(MarkerOptions().position(elisian).title("강촌엘리시안"))
        googleMap.addMarker(MarkerOptions().position(gonjiam).title("곤지암리조트"))
        googleMap.addMarker(MarkerOptions().position(muju).title("무주 덕유산"))

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(yongpyong, 8f))

    }
}