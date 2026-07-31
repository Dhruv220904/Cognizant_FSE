import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Country } from '../models/country.model';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  // Swap this for your Spring Boot backend, e.g. http://localhost:8083/countries
  private apiUrl = '/api/countries';

  constructor(private http: HttpClient) {}

  getCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(this.apiUrl);
  }

  addCountry(country: Country): Observable<Country> {
    return this.http.post<Country>(this.apiUrl, country);
  }
}
