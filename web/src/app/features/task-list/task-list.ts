import { Component, inject, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { Task } from '../../core/models/models';
import { ApiService } from '../../core/services/api.service';
import { Router } from '@angular/router';

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
	private apiService = inject(ApiService);
	private router = inject(Router);

	taskList = signal<Task[] | []>([]);

	constructor() {}

	ngOnInit(): void {
		console.log('hitting');
		this.apiService.getAllTasks().subscribe({
			next: data => { this.taskList.set(data) },
			error: () => {}
		});
	}

  markDone(task: Task) {
    task.status = 'CLOSED';
  }

  navigateToTaskDetails(taskId: number) {
	this.router.navigate(["/task", taskId]);
  }
}