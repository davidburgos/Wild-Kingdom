package co.mobilemakers.wildkingdom;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class MainActivity extends Activity {


    ArrayList<Fragment> mAnimalList = new ArrayList<>();
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener OnClickButton = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                index++;

                if(index >= mAnimalList.size()){
                    index = 0;
                }

                getFragmentManager().beginTransaction().
                        replace(R.id.container,mAnimalList.get(index)).
                        commit();

            }
        };

        Button btnNext = (Button)findViewById(R.id.button);
        btnNext.setOnClickListener(OnClickButton);

        mAnimalList.add(new BlackMarshTurtleFragment());
        mAnimalList.add(new ChupacabraFragment());
        mAnimalList.add(new GoldenLionTamarinFragment());
        mAnimalList.add(new PartulaSnailFragment());
        mAnimalList.add(new RedpandaFragment());
        mAnimalList.add(new SouthAmericanFurSealFragment());

        getFragmentManager().beginTransaction().
                add(R.id.container,mAnimalList.get(0)).
                commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
