import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private List<Task> taskList;
    private OnItemClickListener itemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onCheckboxClick(int position, boolean isChecked);
    }

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        itemClickListener = listener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_item, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task currentTask = taskList.get(position);
        holder.textTitle.setText(currentTask.getTitle());
        holder.textDescription.setText(currentTask.getDescription());
        holder.checkComplete.setChecked(currentTask.isComplete());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle, textDescription;
        CheckBox checkComplete;

        TaskViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
            checkComplete = itemView.findViewById(R.id.checkComplete);

            itemView.setOnClickListener(view -> {
                if (itemClickListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        itemClickListener.onItemClick(position);
                    }
                }
            });

            checkComplete.setOnCheckedChangeListener((compoundButton, isChecked) -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener.onCheckboxClick(position, isChecked);
                }
            });
        }
    }
}
