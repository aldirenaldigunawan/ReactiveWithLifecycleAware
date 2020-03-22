package com.example.reactivewithlifecycleaware.presentation.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reactivewithlifecycleaware.R
import com.example.reactivewithlifecycleaware.presentation.main.MainContract.*
import com.example.reactivewithlifecycleaware.presentation.main.MainContract.LayoutType.*
import com.example.reactivewithlifecycleaware.presentation.main.adapter.GridItemDecorator
import com.example.reactivewithlifecycleaware.presentation.main.adapter.MainAdapter
import com.example.reactivewithlifecycleaware.util.CarModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View {

    private val lifecycleAware: MainLifecycleAware by lazy { MainLifecycleAwareImpl() }
    private val presenter by lazy { MainPresenter() }
    private val adapter by lazy { MainAdapter() }
    private val itemDecorator by lazy {
        GridItemDecorator(
            24,
            2,
            true
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleAware.registerLifecycle(lifecycle)

        presenter.attachView(this)
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_layout_switcher, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item_linear -> {
                presenter.changeLayout(Linear)
                true
            }
            R.id.menu_item_grid -> {
                presenter.changeLayout(Grid)
                true
            }
            R.id.menu_item_single -> {
                presenter.changeLayout(Single)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun renderListView(carModel: List<ListViewObject>) {
        adapter.submitList(carModel)
    }

    override fun renderSingleView(carModel: List<CarModel>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun changeListToLinear() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.removeItemDecoration(itemDecorator)
    }

    override fun changeListToGrid() {
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.addItemDecoration(itemDecorator)
    }

    companion object {

        fun createIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
