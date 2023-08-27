import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Task> taskList;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskList = new ArrayList<>();
        taskAdapter = new TaskAdapter(taskList);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(taskAdapter);

        taskAdapter.setOnItemClickListener(new TaskAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Implement task editing here
            }

            @Override
            public void onCheckboxClick(int position, boolean isChecked) {
                taskList.get(position).setComplete(isChecked);
                taskAdapter.notifyItemChanged(position);
            }
        });

        FloatingActionButton fabAddTask = findViewById(R.id.fabAddTask);
        fabAddTask.setOnClickListener(view -> {
            // Implement task creation here
        });

        // Load tasks from storage or initialize some sample tasks
        initializeSampleTasks();
    }

    private void initializeSampleTasks() {
        taskList.add(new Task("Buy groceries", "Milk, eggs, bread"));
        taskList.add(new Task("Read a book", "Chapter 3"));
        taskList.add(new Task("Go for a run", "5 km"));
        // Add more tasks as needed
        taskAdapter.notifyDataSetChanged();
    }
}
