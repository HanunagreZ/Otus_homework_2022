package ru.hanunagrez.otusfilms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import ru.hanunagrez.otusfilms.databinding.ActivityMainBinding
import ru.hanunagrez.otusfilms.DetailsActivity.Companion.SEND_BOOLEAN


class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding

    private var launcherForrest: ActivityResultLauncher<Intent>? = null
    private var launcherGreen: ActivityResultLauncher<Intent>? = null
    private var launcherInception: ActivityResultLauncher<Intent>? = null
    private var launcherInterstellar: ActivityResultLauncher<Intent>? = null
    private var launcherIntouchables: ActivityResultLauncher<Intent>? = null
    private var launcherLion: ActivityResultLauncher<Intent>? = null
    private var launcherMatrix: ActivityResultLauncher<Intent>? = null
    private var launcherPulp: ActivityResultLauncher<Intent>? = null
    private var launcherShawshank: ActivityResultLauncher<Intent>? = null
    private var launcherShrek: ActivityResultLauncher<Intent>? = null

    var likeForrest = false
    var likeGreen = false
    var likeInception = false
    var likeInterstellar = false
    var likeIntouchables = false
    var likeLion = false
    var likeMatrix = false
    var likePulp = false
    var likeShawshank = false
    var likeShrek = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        if (savedInstanceState != null) {
            mainBinding.tvInception.setTextColor(savedInstanceState.getInt(TEXT_COLOR_INCEPTION))
            mainBinding.tvForrestGump.setTextColor(savedInstanceState.getInt(TEXT_COLOR_FORREST))
            mainBinding.tvGreenMile.setTextColor(savedInstanceState.getInt(TEXT_COLOR_GREEN))
            mainBinding.tvInterstellar.setTextColor(savedInstanceState.getInt(TEXT_COLOR_INTERSTELLAR))
            mainBinding.tvIntouchables.setTextColor(savedInstanceState.getInt(TEXT_COLOR_INTOUCHABLES))
            mainBinding.tvLionKing.setTextColor(savedInstanceState.getInt(TEXT_COLOR_LION))
            mainBinding.tvMatrix.setTextColor(savedInstanceState.getInt(TEXT_COLOR_MATRIX))
            mainBinding.tvPulpFiction.setTextColor(savedInstanceState.getInt(TEXT_COLOR_PULP))
            mainBinding.tvShawshank.setTextColor(savedInstanceState.getInt(TEXT_COLOR_SHAWSHANK))
            mainBinding.tvShrek.setTextColor(savedInstanceState.getInt(TEXT_COLOR_SHREK))
            likeInception = savedInstanceState.getBoolean(LIKE_BOOL_INCEPTION)
            likeForrest = savedInstanceState.getBoolean(LIKE_BOOL_FORREST)
            likeGreen = savedInstanceState.getBoolean(LIKE_BOOL_GREEN)
            likeInterstellar = savedInstanceState.getBoolean(LIKE_BOOL_INTERSTELLAR)
            likeIntouchables = savedInstanceState.getBoolean(LIKE_BOOL_INTOUCHABLES)
            likeLion = savedInstanceState.getBoolean(LIKE_BOOL_LION)
            likeMatrix = savedInstanceState.getBoolean(LIKE_BOOL_MATRIX)
            likePulp = savedInstanceState.getBoolean(LIKE_BOOL_PULP)
            likeShawshank = savedInstanceState.getBoolean(LIKE_BOOL_SHAWSHANK)
            likeShrek = savedInstanceState.getBoolean(LIKE_BOOL_SHREK)
        }

        launcherForrest =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                likeForrest = result.data?.getBooleanExtra(SEND_BOOLEAN, false) == true
                val text = result.data?.getStringExtra("textComment")
                if (result.resultCode == RESULT_OK && text != "") {
                    Log.d("MyLog", "Текст комментария: $text")
                }
                if (likeForrest) {
                    Log.d("MyLog", "Фильм Форрест Гамп в избранном")
                }
            }
        mainBinding.btForrestGump.setOnClickListener {
            mainBinding.tvForrestGump.setTextColor(getColor(R.color.orange))
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(
                "text",
                "Полувековая история США глазами чудака из Алабамы. Абсолютная классика Роберта Земекиса с Томом Хэнксом"
            )
            intent.putExtra("imageId", R.drawable.forrest_gump)
            intent.putExtra("like", likeForrest)
            launcherForrest?.launch(intent)
        }

        launcherGreen =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                likeGreen = result.data?.getBooleanExtra(SEND_BOOLEAN, false) == true
                val text = result.data?.getStringExtra("textComment")
                if (result.resultCode == RESULT_OK && text != "") {
                    Log.d("MyLog", "Текст комментария: $text")
                }
                if (likeGreen == true) {
                    Log.d("MyLog", "Фильм Зеленая миля в избранном")
                }
            }
        mainBinding.btGreenMile.setOnClickListener {
            mainBinding.tvGreenMile.setTextColor(getColor(R.color.orange))
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(
                "text",
                "В тюрьме для смертников появляется заключенный с божественным даром. Мистическая драма по роману Стивена Кинга"
            )
            intent.putExtra("imageId", R.drawable.green_mile)
            intent.putExtra("like", likeGreen)
            launcherGreen?.launch(intent)
        }

        launcherInception =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                likeInception = result.data?.getBooleanExtra(SEND_BOOLEAN, false) == true
                val text = result.data?.getStringExtra("textComment")
                if (result.resultCode == RESULT_OK && text != "") {
                    Log.d("MyLog", "Текст комментария: $text")
                }
                if (likeInception == true) {
                    Log.d("MyLog", "Фильм Начало в избранном")
                }
            }
        mainBinding.btInception.setOnClickListener {
            mainBinding.tvInception.setTextColor(getColor(R.color.orange))
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(
                "text",
                "Профессиональные воры внедряются в сон наследника огромной империи. Фантастический боевик Кристофера Нолана"
            )
            intent.putExtra("imageId", R.drawable.inception)
            intent.putExtra("like", likeInception)
            launcherInception?.launch(intent)
        }

        launcherInterstellar =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                likeInterstellar = result.data?.getBooleanExtra(SEND_BOOLEAN, false) == true
                val text = result.data?.getStringExtra("textComment")
                if (result.resultCode == RESULT_OK && text != "") {
                    Log.d("MyLog", "Текст комментария: $text")
                }
                if (likeInterstellar == true) {
                    Log.d("MyLog", "Фильм Интерстеллар в избранном")
                }
            }
        mainBinding.btInterstellar.setOnClickListener {
            mainBinding.tvInterstellar.setTextColor(getColor(R.color.orange))
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(
                "text",
                "Фантастический эпос про задыхающуюся Землю, космические полеты и парадоксы времени. «Оскар» за спецэффекты"
            )
            intent.putExtra("imageId", R.drawable.interstellar)
            intent.putExtra("like", likeInterstellar)
            launcherInterstellar?.launch(intent)
        }

        launcherIntouchables =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                likeIntouchables = result.data?.getBooleanExtra(SEND_BOOLEAN, false) == true
                val text = result.data?.getStringExtra("textComment")
                if (result.resultCode == RESULT_OK && text != "") {
                    Log.d("MyLog", "Текст комментария: $text")
                }
                if (likeIntouchables == true) {
                    Log.d("MyLog", "Фильм 1+1 в избранном")
                }
            }
        mainBinding.btIntouchables.setOnClickListener {
            mainBinding.tvIntouchables.setTextColor(getColor(R.color.orange))
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(
                "text",
                "Аристократ на коляске нанимает в сиделки бывшего заключенного. Искрометная французская комедия с Омаром Си"
            )
            intent.putExtra("imageId", R.drawable.intouchables)
            intent.putExtra("like", likeIntouchables)
            launcherIntouchables?.launch(intent)
        }

        launcherLion =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                likeLion = result.data?.getBooleanExtra(SEND_BOOLEAN, false) == true
                val text = result.data?.getStringExtra("textComment")
                if (result.resultCode == RESULT_OK && text != "") {
                    Log.d("MyLog", "Текст комментария: $text")
                }
                if (likeLion == true) {
                    Log.d("MyLog", "Фильм Король лев в избранном")
                }
            }
        mainBinding.btLionKing.setOnClickListener {
            mainBinding.tvLionKing.setTextColor(getColor(R.color.orange))
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(
                "text",
                "Львенок Симба бросает вызов дяде-убийце. Величественный саундтрек, рисованная анимация и шекспировский размах"
            )
            intent.putExtra("imageId", R.drawable.lion_king)
            intent.putExtra("like", likeLion)
            launcherLion?.launch(intent)

        }

        launcherMatrix =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                likeMatrix = result.data?.getBooleanExtra(SEND_BOOLEAN, false) == true
                val text = result.data?.getStringExtra("textComment")
                if (result.resultCode == RESULT_OK && text != "") {
                    Log.d("MyLog", "Текст комментария: $text")
                }
                if (likeMatrix == true) {
                    Log.d("MyLog", "Фильм Матрица в избранном")
                }
            }
        mainBinding.btMatrix.setOnClickListener {
            mainBinding.tvMatrix.setTextColor(getColor(R.color.orange))
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(
                "text",
                "Хакер Нео узнает, что его мир — виртуальный. Выдающийся экшен, доказавший, что зрелищное кино может быть умным"
            )
            intent.putExtra("imageId", R.drawable.matrix)
            intent.putExtra("like", likeMatrix)
            launcherMatrix?.launch(intent)

        }

        launcherPulp =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                likePulp = result.data?.getBooleanExtra(SEND_BOOLEAN, false) == true
                val text = result.data?.getStringExtra("textComment")
                if (result.resultCode == RESULT_OK && text != "") {
                    Log.d("MyLog", "Текст комментария: $text")
                }
                if (likePulp == true) {
                    Log.d("MyLog", "Фильм Криминальное чтиво в избранном")
                }
            }
        mainBinding.btPulpFiction.setOnClickListener {
            mainBinding.tvPulpFiction.setTextColor(getColor(R.color.orange))
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(
                "text",
                "Несколько связанных историй из жизни бандитов. Шедевр Квентина Тарантино, который изменил мировое кино"
            )
            intent.putExtra("imageId", R.drawable.pulp_fiction)
            intent.putExtra("like", likePulp)
            launcherPulp?.launch(intent)
        }

        launcherShawshank =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                likeShawshank = result.data?.getBooleanExtra(SEND_BOOLEAN, false) == true
                val text = result.data?.getStringExtra("textComment")
                if (result.resultCode == RESULT_OK && text != "") {
                    Log.d("MyLog", "Текст комментария: $text")
                }
                if (likeShawshank == true) {
                    Log.d("MyLog", "Фильм Побег из Шоушенка в избранном")
                }
            }
        mainBinding.btShawshank.setOnClickListener {
            mainBinding.tvShawshank.setTextColor(getColor(R.color.orange))
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(
                "text",
                "Несправедливо осужденный банкир готовит побег из тюрьмы. Тим Роббинс в выдающейся экранизации Стивена Кинга"
            )
            intent.putExtra("imageId", R.drawable.shawshank_redemption)
            intent.putExtra("like", likeShawshank)
            launcherShawshank?.launch(intent)
        }

        launcherShrek =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                likeShrek = result.data?.getBooleanExtra(SEND_BOOLEAN, false) == true
                val text = result.data?.getStringExtra("textComment")
                if (result.resultCode == RESULT_OK && text != "") {
                    Log.d("MyLog", "Текст комментария: $text")
                }
                if (likeShrek == true) {
                    Log.d("MyLog", "Фильм Шрек в избранном")
                }
            }
        mainBinding.btShrek.setOnClickListener {
            mainBinding.tvShrek.setTextColor(getColor(R.color.orange))
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(
                "text",
                "Огр-мизантроп спасает принцессу, чтобы вернуть свое болото. Революционная анимация о том, что красота — внутри"
            )
            intent.putExtra("imageId", R.drawable.shrek)
            intent.putExtra("like", likeShrek)
            launcherShrek?.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(LIKE_BOOL_INCEPTION, likeInception)
        outState.putBoolean(LIKE_BOOL_FORREST, likeForrest)
        outState.putBoolean(LIKE_BOOL_GREEN, likeGreen)
        outState.putBoolean(LIKE_BOOL_INTERSTELLAR, likeInterstellar)
        outState.putBoolean(LIKE_BOOL_INTOUCHABLES, likeIntouchables)
        outState.putBoolean(LIKE_BOOL_LION, likeLion)
        outState.putBoolean(LIKE_BOOL_MATRIX, likeMatrix)
        outState.putBoolean(LIKE_BOOL_PULP, likePulp)
        outState.putBoolean(LIKE_BOOL_SHAWSHANK, likeShawshank)
        outState.putBoolean(LIKE_BOOL_SHREK, likeShrek)
        outState.putInt(TEXT_COLOR_INCEPTION, mainBinding.tvInception.currentTextColor)
        outState.putInt(TEXT_COLOR_FORREST, mainBinding.tvForrestGump.currentTextColor)
        outState.putInt(TEXT_COLOR_GREEN, mainBinding.tvGreenMile.currentTextColor)
        outState.putInt(TEXT_COLOR_INTERSTELLAR, mainBinding.tvInterstellar.currentTextColor)
        outState.putInt(TEXT_COLOR_INTOUCHABLES, mainBinding.tvIntouchables.currentTextColor)
        outState.putInt(TEXT_COLOR_LION, mainBinding.tvLionKing.currentTextColor)
        outState.putInt(TEXT_COLOR_MATRIX, mainBinding.tvMatrix.currentTextColor)
        outState.putInt(TEXT_COLOR_PULP, mainBinding.tvPulpFiction.currentTextColor)
        outState.putInt(TEXT_COLOR_SHAWSHANK, mainBinding.tvShawshank.currentTextColor)
        outState.putInt(TEXT_COLOR_SHREK, mainBinding.tvShrek.currentTextColor)
    }

    companion object {
        const val TEXT_COLOR_FORREST = "color"
        const val TEXT_COLOR_GREEN = "color2"
        const val TEXT_COLOR_INCEPTION = "color3"
        const val TEXT_COLOR_INTERSTELLAR = "color4"
        const val TEXT_COLOR_INTOUCHABLES = "color5"
        const val TEXT_COLOR_LION = "color6"
        const val TEXT_COLOR_MATRIX = "color7"
        const val TEXT_COLOR_PULP = "color8"
        const val TEXT_COLOR_SHAWSHANK = "color9"
        const val TEXT_COLOR_SHREK = "color10"

        const val LIKE_BOOL_INCEPTION = "like"
        const val LIKE_BOOL_FORREST = "like2"
        const val LIKE_BOOL_GREEN = "like3"
        const val LIKE_BOOL_INTERSTELLAR = "like4"
        const val LIKE_BOOL_INTOUCHABLES = "like5"
        const val LIKE_BOOL_LION = "like6"
        const val LIKE_BOOL_MATRIX = "like7"
        const val LIKE_BOOL_PULP = "like8"
        const val LIKE_BOOL_SHAWSHANK = "like9"
        const val LIKE_BOOL_SHREK = "like10"
    }
}