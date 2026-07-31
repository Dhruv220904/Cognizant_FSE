import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CountryService } from '../../services/country.service';

@Component({
  selector: 'app-country-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './country-form.component.html'
})
export class CountryFormComponent {

  countryForm: FormGroup;
  submitted = false;

  constructor(
    private fb: FormBuilder,
    private countryService: CountryService,
    private router: Router
  ) {
    this.countryForm = this.fb.group({
      code: ['', [Validators.required, Validators.maxLength(3)]],
      name: ['', Validators.required]
    });
  }

  get code() {
    return this.countryForm.get('code');
  }

  get name() {
    return this.countryForm.get('name');
  }

  onSubmit(): void {
    this.submitted = true;
    if (this.countryForm.invalid) {
      return;
    }

    this.countryService.addCountry(this.countryForm.value).subscribe({
      next: () => this.router.navigate(['/countries']),
      error: () => this.router.navigate(['/countries']) // demo fallback
    });
  }
}
