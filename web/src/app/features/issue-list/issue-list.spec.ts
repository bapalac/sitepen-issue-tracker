import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { CommonModule } from '@angular/common';
import { IssueListComponent } from './issue-list';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('IssueListComponent', () => {
  let component: IssueListComponent;
  let fixture: ComponentFixture<IssueListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IssueListComponent, MatCardModule, MatButtonModule, CommonModule, HttpClientTestingModule]
    }).compileComponents();

    fixture = TestBed.createComponent(IssueListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render mock issues', () => {
	component.issueList.set([
		{ id: 1, title: 'Fix login bug', description: 'Fix login bug description', status: 'IN_PROGRESS', priority: 'HIGH', assigneeId: 1, projectId: 1}
	]);

    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    const cards = compiled.querySelectorAll('mat-card');
    expect(cards.length).toBeGreaterThan(0);
    expect(cards[0].textContent).toContain('Fix login bug');
  });

  it('should mark a issue as DONE when markDone is called', () => {
	component.issueList.set([
		{ id: 1, title: 'Fix login bug', description: 'Fix login bug description', status: 'IN_PROGRESS', priority: 'HIGH', assigneeId: 1, projectId: 1}
	]);
    const firstIssue = component.issueList()[0];
    expect(firstIssue.status).not.toBe('CLOSED');

    component.markDone(firstIssue);

    expect(firstIssue.status).toBe('CLOSED');
  });
});
