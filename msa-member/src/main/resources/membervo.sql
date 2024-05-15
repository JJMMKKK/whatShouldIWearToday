ALTER TABLE IF EXISTS public.membervo
    ADD COLUMN country character varying(50);

ALTER TABLE IF EXISTS public.membervo
    ADD COLUMN area character varying(50);

ALTER TABLE IF EXISTS public.membervo
    ALTER COLUMN registerdate SET NOT NULL;

ALTER TABLE IF EXISTS public.membervo
    ALTER COLUMN country SET NOT NULL;

ALTER TABLE IF EXISTS public.membervo
    ALTER COLUMN area SET NOT NULL;