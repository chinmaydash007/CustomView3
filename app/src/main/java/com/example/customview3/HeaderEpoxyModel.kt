package com.example.customview3

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder

@EpoxyModelClass
abstract class HeaderEpoxyModel : EpoxyModelWithHolder<HeaderEpoxyModel.Holder>() {

    @EpoxyAttribute
    lateinit var title:String

    @EpoxyAttribute
    lateinit var list:List<String>



    class Holder : EpoxyHolder() {
        lateinit var title:TextView
        override fun bindView(itemView: View) {
            title=itemView.findViewById(R.id.textView)
        }
    }

    override fun getDefaultLayout(): Int {
        return R.layout.header_layout
    }
}