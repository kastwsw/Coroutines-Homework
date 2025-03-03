package otus.homework.coroutines

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.squareup.picasso.Picasso

class CatsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), ICatsView {

    var presenter: CatsPresenter? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        findViewById<Button>(R.id.button).setOnClickListener {
            presenter?.onInitComplete()
        }
    }

    override fun populate(article: CatArticle) {
        // картинка
        Picasso.get()
            .load(article.pic.url)
            .resize(article.pic.width, article.pic.height)
            .centerCrop()
            .into(findViewById<ImageView>(R.id.pic_view))
        // текст
        findViewById<TextView>(R.id.fact_textView).text = article.fact.fact
    }
}

interface ICatsView {

    fun populate(article: CatArticle)
}