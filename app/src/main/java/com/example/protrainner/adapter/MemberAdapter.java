package com.example.protrainner.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.protrainner.fragment.MemberTabFragment;
import com.example.protrainner.fragment.TrainerTabFragment;

public class MemberAdapter extends FragmentPagerAdapter {
        private Context context;
        int totalTabs;

        public MemberAdapter(FragmentManager fm, Context context, int totalTabs){
            super(fm);
            this.context=context;
            this.totalTabs=totalTabs;
        }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public Fragment getItem(int position){
            switch (position){
                case 0:
                    MemberTabFragment memberTabFragment = new MemberTabFragment();
                    return memberTabFragment;
                case 1:
                    TrainerTabFragment trainerTabFragment = new TrainerTabFragment();
                    return trainerTabFragment;
                default:
                    return null;
            }
        }
}
