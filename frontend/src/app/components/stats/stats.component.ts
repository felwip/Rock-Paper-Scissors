import { Component } from '@angular/core';
// import DatalabelsPlugin from 'chartjs-plugin-datalabels';
import { ChartType, ChartConfiguration, ChartData } from 'chart.js';

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css'],
})
export class StatsComponent {
  public ChartType: ChartType = 'doughnut';
  public ChartOptions: ChartConfiguration['options'] = {
    responsive: true,
    plugins: {
      legend: {
        display: false,
      },
    },
  };
  public ChartData: ChartData<'doughnut', number[], string | string[]> = {
    labels: ['Rock', 'Paper', 'Scissors'],
    datasets: [
      {
        data: [3, 5, 10],
      },
    ],
  };
}
