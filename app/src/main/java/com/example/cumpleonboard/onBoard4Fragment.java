package com.example.cumpleonboard;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.cumpleonboard.databinding.FragmentOnBoard4Binding;

import java.util.Calendar;

public class onBoard4Fragment extends Fragment {

    private FragmentOnBoard4Binding binding;
    private NavController navController;
    public static int selectedYear = -1, selectedMonth = -1, selectedDay = -1;

    public onBoard4Fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentOnBoard4Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.selectfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendario = Calendar.getInstance();
                final int year = calendario.get(Calendar.YEAR);
                final int month = calendario.get(Calendar.MONTH);
                final int day = calendario.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        if (year > Calendar.getInstance().get(Calendar.YEAR)) {
                            Toast.makeText(getContext(), "El año no puede ser mayor que el año actual.", Toast.LENGTH_SHORT).show();
                        } else if (year == Calendar.getInstance().get(Calendar.YEAR) && dayOfMonth > day) {
                            Toast.makeText(getContext(), "La fecha no puede ser mayor a la actual", Toast.LENGTH_SHORT).show();
                        } else {
                            String fechaSeleccionada = dayOfMonth + "/" + (month + 1) + "/" + year;
                            binding.FechaNacText.setText(fechaSeleccionada);
                            selectedYear = year;
                            selectedMonth = month;
                            selectedDay = dayOfMonth;
                        }
                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), dateSetListener, year, month, day);
                datePickerDialog.show();
            }
        });

        binding.buttonf4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedYear == -1 || selectedMonth == -1 || selectedDay == -1) {
                    Toast.makeText(getContext(), "Por favor, selecciona una fecha de nacimiento.", Toast.LENGTH_SHORT).show();
                } else if (selectedYear > Calendar.getInstance().get(Calendar.YEAR)) {
                    Toast.makeText(getContext(), "Selecciona una fecha de nacimiento válida.", Toast.LENGTH_SHORT).show();
                } else {
                    if (selectedYear == Calendar.getInstance().get(Calendar.YEAR) && selectedDay > Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) {
                        Toast.makeText(getContext(), "La fecha no puede ser mayor a la actual", Toast.LENGTH_SHORT).show();
                    } else {
                        navController.navigate(R.id.action_onBoard4Fragment_to_onBoard5Fragment);
                    }
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
