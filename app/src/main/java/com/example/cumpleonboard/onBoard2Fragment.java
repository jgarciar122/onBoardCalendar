package com.example.cumpleonboard;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.cumpleonboard.databinding.FragmentOnBoard2Binding;

public class onBoard2Fragment extends Fragment {

    private FragmentOnBoard2Binding binding;

    public onBoard2Fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoard2Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.buttonf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView);
                navController.navigate(R.id.action_onBoard2Fragment_to_onBoard3Fragment);
            }
        });

        binding.skipf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView);
                navController.navigate(R.id.action_onBoard2Fragment_to_onBoard4Fragment);
            }
        });

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Libera el binding para evitar pérdidas de memoria
        binding = null;
    }
}