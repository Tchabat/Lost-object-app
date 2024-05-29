package com.example.franck.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.franck.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel = new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;

        // Option 1: Set initial text while waiting for ViewModel (optional)
        // textView.setText("Loading...");  // Example for initial loading text

        // Observe ViewModel text for updates
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), text -> {
            if (text != null) {
                textView.setText(text);
            } else {
                // Handle the case where ViewModel text is null (optional)
                textView.setText("");  // Example
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
