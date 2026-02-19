import { Component, CUSTOM_ELEMENTS_SCHEMA, inject, Input, OnInit, signal } from '@angular/core';
import { ApiService } from '../../core/services/api.service';
import { Issue } from '../../core/models/models';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { Router } from '@angular/router';
import { IssueListComponent } from '../issue-list/issue-list';

@Component({
  selector: 'app-project-details',
  imports: [
	CommonModule,
    MatCardModule,
    MatIconModule,
    MatButtonModule,
	IssueListComponent
  ],
  schemas: [
	CUSTOM_ELEMENTS_SCHEMA
  ],
  templateUrl: './project-details.html',
  styleUrl: './project-details.css',
})
export class ProjectDetailsComponent implements OnInit{
	private apiService = inject(ApiService);
	private router = inject(Router);

 	@Input() projectId!: number;

	issueList = signal<Issue[] | null>(null);

	constructor() {}

	ngOnInit(): void {
		this.apiService.getAllIssuesByProjectId(this.projectId).subscribe({
			next: data => { this.issueList.set(data) },
			error: () => {}
		});
	}

	navigateToIssueDetails(issueId: number) {
		this.router.navigate(["/issue", issueId]);
	}
}
