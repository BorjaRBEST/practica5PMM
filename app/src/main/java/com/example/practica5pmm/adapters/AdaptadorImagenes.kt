package com.example.practica5pmm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practica5pmm.R

class AdaptadorImagenes(private val imagenes: List<String>) :
    RecyclerView.Adapter<AdaptadorImagenes.ViewHolderImagen>() {

    inner class ViewHolderImagen(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.viewPager)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderImagen {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_razas_imagenes, parent, false)
        return ViewHolderImagen(vista)
    }

    override fun onBindViewHolder(holder: ViewHolderImagen, position: Int) {
        val urlImagen = imagenes[position]
        Glide.with(holder.imageView)
            .load(urlImagen)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return imagenes.size
    }
}
