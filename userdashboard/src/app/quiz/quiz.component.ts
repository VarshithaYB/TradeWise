import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { QuizService } from '../quiz.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent {

  questions: any[] = [];
  currentQuestionIndex: number = 0;
  selectedOption: any;

  constructor(private quizService: QuizService, private router: Router) {}

  ngOnInit() {
    this.questions = this.quizService.getQuestions();
  }

  onNext() {
    if (this.selectedOption) {
      this.quizService.setScore(this.selectedOption.score);
      this.selectedOption = null; // Reset selection
      this.currentQuestionIndex++;

      if (this.currentQuestionIndex === this.questions.length) {
        this.router.navigate(['/result']); // Navigate to result
      }
    } else {
      alert('Please select an option.');
    }
  }
}




