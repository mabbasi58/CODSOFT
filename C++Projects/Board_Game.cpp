#include <iostream>
#include <vector>
using namespace std;

struct Task {
    string description;
    bool completed;

    Task(string desc) : description(desc), completed(false) {}
};

class TaskList {
private:
    vector<Task> tasks;

public:
    void addTask(string description) {
        tasks.push_back(Task(description));
    }

    void viewTasks() {
        if (tasks.empty()) {
            cout << "No tasks in the list." << endl;
        } else {
            cout << "Task List:" << endl;
            for (size_t i = 0; i < tasks.size(); i++) {
                cout << i + 1 << ". " << (tasks[i].completed ? "[X] " : "[ ] ") << tasks[i].description << endl;
            }
        }
    }

    void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks[index].completed = true;
            cout << "Task marked as completed." << endl;
        } else {
            cout << "Invalid task index." << endl;
        }
    }

    void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.erase(tasks.begin() + index);
            cout << "Task removed." << endl;
        } else {
            cout << "Invalid task index." << endl;
        }
    }
};

int main() {
    TaskList taskList;
    int choice;

    while (true) {
        cout << "Task List Program" << endl;
        cout << "1. Add Task" << endl;
        cout << "2. View Tasks" << endl;
        cout << "3. Mark Task as Completed" << endl;
        cout << "4. Remove Task" << endl;
        cout << "5. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                string taskDesc;
                cout << "Enter task description: ";
                cin.ignore(); // Clear the newline character from the input buffer
                getline(cin, taskDesc);
                taskList.addTask(taskDesc);
                break;
            }
            case 2:
                taskList.viewTasks();
                break;
            case 3: {
                int taskIndex;
                cout << "Enter task index to mark as completed: ";
                cin >> taskIndex;
                taskList.markTaskCompleted(taskIndex - 1);
                break;
            }
            case 4: {
                int taskIndex;
                cout << "Enter task index to remove: ";
                cin >> taskIndex;
                taskList.removeTask(taskIndex - 1);
                break;
            }
            case 5:
                cout << "Exiting the program." << endl;
                return 0;
            default:
                cout << "Invalid choice. Try again." << endl;
                break;
        }
    }

    return 0;
}
