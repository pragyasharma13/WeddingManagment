package com.example.weddingmanagemnt1.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.weddingmanagemnt1.Adapter.ServiceAdapter;
import com.example.weddingmanagemnt1.Adapter.ViewPagerAdapter;
import com.example.weddingmanagemnt1.Model.ServiceModel;
import com.example.weddingmanagemnt1.Model.VideoManager;
import com.example.weddingmanagemnt1.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class HomeFragment extends Fragment {

    RecyclerView rv_Item_category;
    LinearLayoutManager gridLayoutManager;
    List<ServiceModel> serviceModels;
    Context context;
    ViewPager viewPager;
    private LinearLayout dynamic_ll;
    ViewPager viewPager_banner;
    ServiceAdapter servicesAdapter;
    private String cat_id,category_name,sub_category_name,sub_id,sub_category_image;
    private TextView cat_name_tv;
    public List<ServiceModel> recentlyViewedList;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        //  rv_Item_category = (RecyclerView) view.findViewById(R.id.recyclerview);




        LayoutInflater inflater1 = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);

        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new ServiceModel("venues",  R.drawable.venues1 ));
        recentlyViewedList.add(new ServiceModel("Photography", R.drawable.photographer1));
        recentlyViewedList.add(new ServiceModel("Menu", R.drawable.menu1));
        recentlyViewedList.add(new ServiceModel("Decoration", R.drawable.decoration));
        recentlyViewedList.add(new ServiceModel("other", R.drawable.venues1));
        RecyclerView myrv = view.findViewById(R.id.rv_Item_category);
        servicesAdapter = new ServiceAdapter(getActivity(), recentlyViewedList);
        myrv.setLayoutManager(new LinearLayoutManager (getActivity(), LinearLayoutManager.HORIZONTAL, false));
        myrv.setAdapter(servicesAdapter);
        // LinearLayoutManager myrv = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        /** rv_Item_category.setLayoutManager(linearLayoutManager);

         rv_Item_category.setAdapter(servicesAdapter);
         rv_Item_category.setHasFixedSize(true);**/
        viewPager = (ViewPager) view.findViewById(R.id.viewPager_banner);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this.getActivity());
        viewPager.setAdapter(adapter);
        //videoview
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv_Item_Subcategory);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true); // to improve performance
        rv.setAdapter(new VideoManager()); // the projectdatabase manager is assigner to the RV


        return view;
    }
}

