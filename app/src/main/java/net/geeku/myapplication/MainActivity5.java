package net.geeku.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity5 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity5);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //添加子菜单
        SubMenu subMenu = menu.addSubMenu(0,1,Menu.NONE, "二级菜单").setIcon(android.R.drawable.ic_menu_share);
        //添加子菜单项
        subMenu.add(2, 201, 1, "1");
        subMenu.add(2, 202, 2, "2");
        subMenu.add(2, 203, 3, "3");

        menu.add(0, 2, Menu.NONE, "主页").setIcon(android.R.drawable.ic_menu_edit);
        menu.add(0, 3, Menu.NONE, "计算器").setIcon(android.R.drawable.ic_menu_close_clear_cancel);
        menu.add(0, 4, Menu.NONE, "Toast").setIcon(android.R.drawable.ic_menu_add);
        menu.add(0, 5, Menu.NONE, "退出").setIcon(android.R.drawable.ic_menu_delete);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case 2:
                startActivity(new Intent(MainActivity5.this, MainActivity.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity5.this, MainActivity2.class));
                break;
            case 4:
                Toast.makeText(MainActivity5.this, "Helloooo Toast", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
