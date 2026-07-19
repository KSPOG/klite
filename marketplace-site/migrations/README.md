# Marketplace D1 migrations

Apply migrations in numeric order. Migration `0009_password_reset.sql` adds the
short-lived Discord password-recovery state and one-time reset-token tables used
by the website account recovery controls.
