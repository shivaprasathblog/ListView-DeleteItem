package com.example.listview_deleteitem;


import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	ListView lv;
	CheckBox selectall;
	Button delete;
	
	ArrayList<String>gadgets_array = new ArrayList<String>();
	ArrayAdapter<String> ad ;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.listView1);
		selectall=(CheckBox)findViewById(R.id.checkBox1);
		delete=(Button)findViewById(R.id.button1);
		
		
		gadgets_array.add("Laptop");
		gadgets_array.add("Tablet");
		gadgets_array.add("Desktop");
		gadgets_array.add("Keyboard");
		gadgets_array.add("Harddisk");
		gadgets_array.add("RAM");
		gadgets_array.add("Printer");
		
		
		//simple_list_item_multiple_choice - will make Listview with Multichoice Option
		ad= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_multiple_choice, gadgets_array);
			
		lv.setAdapter(ad);
		
		//Making Listview with MultiChoice(Checkbox)
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		
		selectall.setOnCheckedChangeListener(new OnCheckedChangeListener() 
		{
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) 
			{
				// TODO Auto-generated method stub
				// CheckBox chk = (CheckBox) v;
	                int itemCount = lv.getCount();
	                
	                for(int i=0 ; i < itemCount ; i++)
	                {
	                	//lv.setItemChecked(position, value)
	                    lv.setItemChecked(i, selectall.isChecked());
	    
	                }
			}
		});
		
		delete.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				    SparseBooleanArray checkedItemPositions = lv.getCheckedItemPositions();
	                int itemCount = lv.getCount();
	 
	                for(int i=itemCount-1; i >= 0; i--)
	                {
	                    if(checkedItemPositions.get(i))
	                    {
	                        ad.remove(gadgets_array.get(i));
	                    }
	                }
	                checkedItemPositions.clear();
	                ad.notifyDataSetChanged();
				
			}
		});
	}
}
