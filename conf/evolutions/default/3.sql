# --- !Ups

CREATE TABLE emr_service_state;
(
  task_id UUID PRIMARY KEY NOT NULL,
  as_of   TIMESTAMP WITH TIME ZONE NOT NULL,
  status  task_executor_status NOT NULL,
  step_id VARCHAR(255)
);

# --- !Downs

DROP TABLE IF EXISTS public.emr_service_state;
