import { Component, inject, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { Issue } from '../../core/models/models';
import { ApiService } from '../../core/services/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-issue-list',
  standalone: true,
  imports: [
    CommonModule,
    MatCardModule,
    MatIconModule,
    MatButtonModule
  ],
  templateUrl: './issue-list.html',
  styleUrls: ['./issue-list.css']
})
export class IssueListComponent implements OnInit {
	private apiService = inject(ApiService);
	private router = inject(Router);

	issueList = signal<Issue[] | []>([]);

	constructor() {}

	ngOnInit(): void {
		this.apiService.getAllIssues().subscribe({
			next: data => { this.issueList.set(data) },
			error: () => {}
		});
	}

  markDone(issue: Issue) {
    issue.status = 'CLOSED';
  }

  navigateToIssueDetails(issueId: number) {
	this.router.navigate(["/issue", issueId]);
  }
}