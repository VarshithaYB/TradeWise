import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QuizService } from '../quiz.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
  score: number = 0;
  suggestion: string = '';

  constructor(private quizService: QuizService, private router: Router) {}

  ngOnInit() {
    this.score = this.quizService.getScore();
    this.suggestion = this.getSuggestion(this.score);
  }

  getSuggestion(score: number): string {
    if (score >= 80) return 'You are a high-risk investor. Focus on growth stocks.';
    if (score >= 50) return 'You are a moderate-risk investor. Focus on balanced portfolios.';
    return 'You prefer low risk. Focus on bonds and blue-chip stocks.';
  }

  restartQuiz() {
    this.quizService.resetScore();
    this.router.navigate(['/quiz']);
  }
}



