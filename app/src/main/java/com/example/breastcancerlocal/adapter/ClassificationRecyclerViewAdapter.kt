package com.example.breastcancerlocal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.breastcancerlocal.R
import com.example.breastcancerlocal.model.DiabeatsVO
import com.example.breastcancerlocal.fragments.ListFragment

class ClassificationRecyclerViewAdapter(items: List<DiabeatsVO>, listener: ListFragment.OnListFragmentInteractionListener)
    : RecyclerView.Adapter<ClassificationRecyclerViewAdapter.ViewHolder>() {

    private var mValues: List<DiabeatsVO> = items
    private var mListener: ListFragment.OnListFragmentInteractionListener = listener


    // Returns a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.listrowitems_layout, parent,
            false)
        return ViewHolder(itemView)
    }

    // Displays data at a certain position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = mValues[position]
        holder.listClassificationidView.text = " " + mValues[position].getId() + " "
        holder.listClassificationoneView.text = " " + mValues[position].getPregnancies() + " "
        holder.listClassificationtwoView.text = " " + mValues[position].getGlucose() + " "
        holder.listClassificationthreeView.text = " " + mValues[position].getBloodPressure() + " "
        holder.listClassificationfourView.text = " " + mValues[position].getSkinThickness() + " "
        holder.listClassificationfiveView.text = " " + mValues[position].getBmi() + " "
        holder.listClassificationsixView.text = " " + mValues[position].getDiabetesPedigreeFunction() + " "
        holder.listClassificationsevenView.text = " " + mValues[position].getAge() + " "
        holder.listClassificationresultView.text = " " + mValues[position].getOutcome() + " "

        holder.mView.setOnClickListener {
            mListener?.onListFragmentInteraction(holder.mItem)
        }
    }

    // Returns size of data list
    override fun getItemCount(): Int {
        return mValues.size
    }

    // Describes an item view and its place within the RecyclerView
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var mView: View
        var listClassificationidView: TextView
        var listClassificationoneView: TextView
        var listClassificationtwoView: TextView
        var listClassificationthreeView: TextView
        var listClassificationfourView: TextView
        var listClassificationfiveView: TextView
        var listClassificationsixView: TextView
        var listClassificationsevenView: TextView
        var listClassificationresultView: TextView
        lateinit var mItem: DiabeatsVO

        init {
            mView = view
            listClassificationidView = view.findViewById(R.id.listClassificationidView)
            listClassificationoneView = view.findViewById(R.id.listClassificationoneView)
            listClassificationtwoView = view.findViewById(R.id.listClassificationtwoView)
            listClassificationthreeView = view.findViewById(R.id.listClassificationthreeView)
            listClassificationfourView = view.findViewById(R.id.listClassificationfourView)
            listClassificationfiveView = view.findViewById(R.id.listClassificationfiveView)
            listClassificationsixView = view.findViewById(R.id.listClassificationsixView)
            listClassificationsevenView = view.findViewById(R.id.listClassificationsevenView)
            listClassificationresultView = view.findViewById(R.id.listClassificationresultView)
        }

        override fun toString(): String {
            return super.toString() + " " + mItem
        }
    }
}
