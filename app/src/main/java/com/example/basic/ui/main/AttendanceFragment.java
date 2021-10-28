package com.example.basic.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic.AddNewUser;
import com.example.basic.R;
import com.example.basic.room.AppDatabase;
import com.example.basic.room.User;
import com.example.basic.room.UserListAdapter;

import java.util.List;


public class AttendanceFragment extends Fragment {
    UserListAdapter userListAdapter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_take_attendance, container, false);
        Button addUser = view.findViewById(R.id.addNewUserButton);
        recyclerView = view.findViewById(R.id.recyclerView);
        addUser.setOnClickListener(v -> {
            startActivityForResult(new Intent(this.getActivity(), AddNewUser.class), 100);
        });

        initRecyclerView();
        loadUserList();
        return view;
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL));
        userListAdapter = new UserListAdapter(this.getContext());
        recyclerView.setAdapter(userListAdapter);
    }

    private void loadUserList() {
        AppDatabase db = AppDatabase.getDbInstance(this.getContext());
        List<User> userList = db.userDao().getAllUsers();
        userListAdapter.setUserList(userList);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        if (requestCode == 100) {

        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
