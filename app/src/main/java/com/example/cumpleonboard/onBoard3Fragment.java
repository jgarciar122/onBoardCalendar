package com.example.cumpleonboard;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.cumpleonboard.databinding.FragmentOnBoard3Binding;

public class onBoard3Fragment extends Fragment {

    private FragmentOnBoard3Binding binding;

    public onBoard3Fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoard3Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.buttonf3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView);
                navController.navigate(R.id.action_onBoard3Fragment_to_onBoard4Fragment);
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