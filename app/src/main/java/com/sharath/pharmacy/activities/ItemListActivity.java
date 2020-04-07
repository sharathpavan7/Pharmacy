package com.sharath.pharmacy.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.sharath.pharmacy.R;
import com.sharath.pharmacy.api.ApiAdapter;
import com.sharath.pharmacy.api.ApiService;
import com.sharath.pharmacy.database.AppDatabaseClient;
import com.sharath.pharmacy.database.dao.ItemDao;
import com.sharath.pharmacy.database.entities.ItemEntity;
import com.sharath.pharmacy.models.Item;
import com.sharath.pharmacy.response.ItemsListApiResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getItemsList();
    }

    private void getItemsList() {

        ApiService apiService = ApiAdapter.getClient
                (this).create(ApiService.class);

        Call<ItemsListApiResponse> serverCom = apiService.fetchItems();

        serverCom.enqueue(new Callback<ItemsListApiResponse>() {

            @Override
            public void onResponse(@NonNull Call<ItemsListApiResponse> call,
                                   @NonNull Response<ItemsListApiResponse> response) {
                saveItemsInDB(response.body().itemArrayList);
            }

            @Override
            public void onFailure(@NonNull Call<ItemsListApiResponse> call, @NonNull Throwable t) {

            }
        });

    }

    private void saveItemsInDB(final ArrayList<Item> items) {

        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //adding to database
                ItemDao itemDao = AppDatabaseClient.getInstance(ItemListActivity.this.getApplicationContext()).getAppDatabase()
                        .itemDao();

                itemDao.deletAll();

                for (Item item: items) {
                    ItemEntity itemEntity = new ItemEntity();
                    itemEntity.setItemCode(item.getItemCode());
                    itemEntity.setItemName(item.getItemName());
                    itemEntity.setItemPic(item.getItemPic());
                    itemEntity.setMadicineType(item.getMadicineType());
                    itemEntity.setManufacturer(item.getManufacturer());
                    itemEntity.setMinimumQty(item.getMinimumQty());
                    itemEntity.setPack(item.getPack());
                    itemEntity.setPackQty(item.getPackQty());
                    itemEntity.setPrice(item.getPrice());

                    itemDao.insert(itemEntity);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                getItems();
            }

        }

        SaveTask st = new SaveTask();
        st.execute();
    }

    private void getItems() {
        class GetItemsTasks extends AsyncTask<Void, Void, List<ItemEntity>> {

            @Override
            protected List<ItemEntity> doInBackground(Void... voids) {
                List<ItemEntity> taskList = AppDatabaseClient
                        .getInstance(ItemListActivity.this)
                        .getAppDatabase()
                        .itemDao()
                        .getAll();
                return taskList;
            }

            @Override
            protected void onPostExecute(List<ItemEntity> feedEntities) {
                super.onPostExecute(feedEntities);
            }
        }

        GetItemsTasks gt = new GetItemsTasks();
        gt.execute();
    }
}
