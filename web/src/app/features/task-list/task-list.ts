import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { Task } from '../../core/models/models';
import { ApiService } from '../../core/services/api.service';

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [
    CommonModule,
    MatCardModule,
    MatIconModule,
    MatButtonModule
  ],
  templateUrl: './task-list.html',
  styleUrls: ['./task-list.css']
})
export class TaskListComponent implements OnInit {

	taskList = signal<Array<Task> | []>([]);

	constructor(private apiService: ApiService) {}

	ngOnInit(): void {
		this.apiService.getAllTasks().subscribe({
			next: data => { this.taskList.set(data) },
			error: () => {}
		});
	}

  markDone(task: Task) {
    task.status = 'CLOSED';
  }
}