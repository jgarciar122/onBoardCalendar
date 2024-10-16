package com.example.cumpleonboard;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.cumpleonboard.databinding.FragmentOnBoard5Binding;

import java.util.Calendar;

public class onBoard5Fragment extends Fragment {
    private FragmentOnBoard5Binding binding;
    NavController navController;

    public onBoard5Fragment() {
        // Constructor vacío
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentOnBoard5Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        int year = onBoard4Fragment.selectedYear;
        int month = onBoard4Fragment.selectedMonth;
        int day = onBoard4Fragment.selectedDay;

        Calendar fecha = Calendar.getInstance();
        fecha.set(year, month, day);

        Calendar hoy = Calendar.getInstance();
        int age = hoy.get(Calendar.YEAR) - fecha.get(Calendar.YEAR);

        if (hoy.get(Calendar.DAY_OF_YEAR) < fecha.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        String resultado = "Has dado " + age + " vueltas al sol";
        binding.textCalendario.setText(resultado);

        binding.buttonf5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_onBoard5Fragment_to_onBoard4Fragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Liberamos el binding para evitar pérdidas de memoria
    }
}
