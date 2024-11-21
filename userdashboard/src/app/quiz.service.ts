
  import { Injectable } from '@angular/core';
import { QUESTIONS } from '../../../userdashboard/src/app/quiz/questions';
@Injectable({
  providedIn: 'root'
})
export class QuizService {
  private totalScore = 0;

  getQuestions() {
    return QUESTIONS;
  }

  setScore(score: number) {
    this.totalScore += score;
  }

  getScore() {
    return this.totalScore;
  }

  resetScore() {
    this.totalScore = 0;
  }
}


