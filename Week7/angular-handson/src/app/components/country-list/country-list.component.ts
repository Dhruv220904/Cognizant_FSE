import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { CountryService } from '../../services/country.service';
import { Country } from '../../models/country.model';

@Component({
  selector: 'app-country-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './country-list.component.html'
})
export class CountryListComponent implements OnInit {

  countries: Country[] = [];
  loading = true;
  errorMessage = '';

  constructor(private countryService: CountryService) {}

  ngOnInit(): void {
    this.countryService.getCountries().subscribe({
      next: (data) => {
        this.countries = data;
        this.loading = false;
      },
      error: (err) => {
        // Fallback demo data so the UI is inspectable even without a live backend
        this.countries = [
          { code: 'IN', name: 'India' },
          { code: 'US', name: 'United States' },
          { code: 'JP', name: 'Japan' }
        ];
        this.errorMessage = 'Could not reach API — showing demo data instead.';
        this.loading = false;
      }
    });
  }
}
