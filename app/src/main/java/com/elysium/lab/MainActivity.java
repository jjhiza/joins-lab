package com.elysium.lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private EmployeeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        Helper helper = Helper.getInstance(this);

        Employee employee = new Employee ("123-04-5678", "John", "Smith", "1973", "NY");
        Employee employee1 = new Employee ("123-04-5679", "David", "McWill", "1982", "Seattle");
        Employee employee2 = new Employee ("123-04-5680", "Katerina", "Wise", "1973", "Boston");
        Employee employee3 = new Employee ("123-04-5681", "Donald", "Lee", "1992", "London");
        Employee employee4 = new Employee ("123-04-5682", "Gary", "Henwood", "1987", "Las Vegas");
        Employee employee5 = new Employee ("123-04-5683", "Anthony", "Bright", "1963", "Seattle");
        Employee employee6 = new Employee ("123-04-5684", "William", "Newey", "1995", "Boston");
        Employee employee7 = new Employee ("123-04-5685", "Melony", "Smith", "1970", "Chicago");

        Company company = new Company ("Fuzz");
        Company company1 = new Company ("GA");
        Company company2 = new Company ("Little Place");
        Company company3 = new Company ("Macys");
        Company company4 = new Company ("New Life");
        Company company5 = new Company ("Believe");
        Company company6 = new Company ("Macys");
        Company company7 = new Company ("Stop");

        helper.insertRow(employee);
        helper.insertRow(employee1);
        helper.insertRow(employee2);
        helper.insertRow(employee3);
        helper.insertRow(employee4);
        helper.insertRow(employee5);
        helper.insertRow(employee6);
        helper.insertRow(employee7);

        helper.insertRowCompany(company);
        helper.insertRowCompany(company1);
        helper.insertRowCompany(company2);
        helper.insertRowCompany(company3);
        helper.insertRowCompany(company4);
        helper.insertRowCompany(company5);
        helper.insertRowCompany(company6);
        helper.insertRowCompnay(company7);

        List<String> names = helper.getNameJoins();
        List<String> fullInfo = helper.getFullInfo();

        mAdapter = new EmployeeAdapter(fullInfo);
        mRecyclerView.setAdapter(mAdapter);

    }
}
