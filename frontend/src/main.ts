import { bootstrapApplication } from '@angular/platform-browser';

import { provideHttpClient } from '@angular/common/http';
import { LabseqComponent } from './app/app.component';

bootstrapApplication(LabseqComponent, {
  providers: [provideHttpClient()]
}).catch(err => console.error(err));